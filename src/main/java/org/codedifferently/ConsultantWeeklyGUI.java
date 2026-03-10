package org.codedifferently;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ConsultantWeeklyGUI {

    private ManagementSystem management;
    private JFrame frame;
    private JTextArea outputArea;
    private JPanel calendarPanel;
    private JScrollPane calendarScrollPane;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
// Main GUI interface
    public ConsultantWeeklyGUI() {

        management = ManagementSystem.loadData();

        frame = new JFrame("Lan & Amani Consultant Weekly Calendar");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.EAST);


// Buttons
        JPanel topPanel = new JPanel(new FlowLayout());
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");
        JButton checkInBtn = new JButton("Check-In");
        JButton saveBtn = new JButton("Save Data");
        JButton dailyReportBtn = new JButton("Daily Report");
        JButton viewScheduleBtn = new JButton("View Schedule");
        JButton viewAllCustomersBtn = new JButton("View All Customers");
        topPanel.add(viewAllCustomersBtn);

        topPanel.add(addCustomerBtn);
        topPanel.add(searchCustomerBtn);
        topPanel.add(checkInBtn);
        topPanel.add(saveBtn);
        topPanel.add(dailyReportBtn);
        topPanel.add(viewScheduleBtn);
        frame.add(topPanel, BorderLayout.NORTH);

        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(19, 8, 2, 2));
        calendarScrollPane = new JScrollPane(calendarPanel);
        frame.add(calendarScrollPane, BorderLayout.CENTER);


        // ---------------- Actions ----------------
        viewAllCustomersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("--- All Customers ---\n");
                ArrayList<Customer> customers = management.getCustomers();
                if (customers.isEmpty()) {
                    outputArea.append("No customer found.\n");
                } else {
                    for (Customer p : customers) {
                        outputArea.append(p.toString() + "\n");
                    }
                }
            }
        });
        addCustomerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Customer Name:");

                if (name != null && !name.trim().isEmpty()) {
                    management.addCustomer(name.trim());
                    outputArea.append("Added customer: " + name + "\n");
                    updateCalendar();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid customer name.");
                }
                }

        });

        searchCustomerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "Customer ID or Name:");
                Customer c = management.searchCustomer(id);
                if (c != null) outputArea.append(c.toString() + "\n");
                else outputArea.append("customer not found.\n");
            }
        });

        checkInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "customer ID:");
                management.checkInCustomer(id);
                outputArea.append("Checked in: " + id + "\n");
                updateCalendar();
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                management.saveData();
                JOptionPane.showMessageDialog(frame, "Data saved successfully.");
            }
        });

        dailyReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("--- Daily Report ---\n");
                LocalDate today = LocalDate.now();
                int total = 0, completed = 0;
                for (Appointment a : management.getAppointments()) {
                    if (a.getTime().toLocalDate().equals(today)) {
                        total++;
                        if (a.isCompleted()) completed++;
                    }
                }
                outputArea.append("Appointments Today: " + total + "\n");
                outputArea.append("Completed Today: " + completed + "\n");
            }
        });

        viewScheduleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("--- All Appointments ---\n");
                for (Appointment a : management.getAppointments()) outputArea.append(a.toString() + "\n");
            }
        });

        updateCalendar();
        frame.setVisible(true);
    }

    // ---------------- Calendar ----------------
    private void updateCalendar() {
        calendarPanel.removeAll();

        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        final LocalDateTime nowSlot = LocalDateTime.of(today,
                nowTime.withMinute((nowTime.getMinute() / 30) * 30).withSecond(0).withNano(0));
//use ArrayList to show calender panel
        java.util.List<LocalDate> weekDates = new ArrayList<>();
        for (int i = 0; i < 7; i++) weekDates.add(today.plusDays(i));

        calendarPanel.add(new JLabel("Time"));
        for (LocalDate d : weekDates) calendarPanel.add(new JLabel(d.getDayOfWeek() + " " + d.toString()));

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 0);

        JButton currentSlotButton = null;

        while (!start.isAfter(end.minusMinutes(30))) {
            final LocalTime displayTime = start;
            calendarPanel.add(new JLabel(displayTime.toString()));

            for (LocalDate date : weekDates) {
                final LocalDateTime slotTime = LocalDateTime.of(date, start);
                final java.util.List<String> customerNames = new ArrayList<>(management.getCustomerNamesForSlot(slotTime));
                final int waitlistCount = management.getWaitlistMap().containsKey(slotTime)
                        ? management.getWaitlistMap().get(slotTime).size() : 0;

                String label;
                if (customerNames.isEmpty()) label = "Available";
                else if (waitlistCount > 0) label = customerNames.get(0) + " (" + waitlistCount + " waitlist)";
                else label = customerNames.get(0);

                final String buttonLabel = label;
                JButton slotBtn = new JButton(buttonLabel);

                if (customerNames.isEmpty()) slotBtn.setBackground(Color.GREEN);
                else if (waitlistCount > 0) slotBtn.setBackground(Color.ORANGE);
                else slotBtn.setBackground(Color.RED);

                slotBtn.setOpaque(true);
                slotBtn.setBorderPainted(true);

                if (slotTime.equals(nowSlot)) {
                    slotBtn.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                    currentSlotButton = slotBtn;
                } else {
                    slotBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }

                // LEFT-CLICK
                slotBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        handleSlotClick(slotTime);
                    }
                });

                // RIGHT-CLICK popup menu
                JPopupMenu menu = new JPopupMenu();
                JMenuItem scheduleItem = new JMenuItem("Schedule / Join Waitlist");
                JMenuItem completeItem = new JMenuItem("Complete Appointment");
                JMenuItem cancelItem = new JMenuItem("Cancel Appointment");

                scheduleItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        handleSlotClick(slotTime);
                    }
                });
                completeItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        handleComplete(slotTime);
                    }
                });
                cancelItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        handleCancel(slotTime);
                    }
                });

                menu.add(scheduleItem);
                menu.add(completeItem);
                menu.add(cancelItem);
                slotBtn.setComponentPopupMenu(menu);

                calendarPanel.add(slotBtn);
            }

            start = start.plusMinutes(30);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();

        if (currentSlotButton != null) {
            final JButton scrollBtn = currentSlotButton;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Rectangle rect = scrollBtn.getBounds();
                    calendarScrollPane.getViewport().scrollRectToVisible(rect);
                }
            });
        }
    }

    // ---------------- Slot Handlers ----------------
    private void handleSlotClick(LocalDateTime slotTime) {
        String customerID = JOptionPane.showInputDialog(frame, "Enter Customer ID:");
        if (customerID == null || customerID.isEmpty()) return;

        if (management.isSlotAvailable(slotTime)) {
            management.scheduleAppointment(customerID, slotTime);
            outputArea.append("Scheduled " + customerID + " at " + slotTime.format(dtf) + "\n");
        } else {
            int option = JOptionPane.showConfirmDialog(frame,
                    "Slot taken. Join waitlist?", "Waitlist", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                management.scheduleAppointment(customerID, slotTime);
                outputArea.append("Added to waitlist: " + customerID + " at " + slotTime.format(dtf) + "\n");
            }
        }
        updateCalendar();
    }

    private void handleComplete(LocalDateTime slotTime) {
        String customerID = JOptionPane.showInputDialog(frame, "Enter Customer ID to complete:");
        if (customerID == null || customerID.isEmpty()) return;
        management.completeAppointment(customerID, slotTime);
        outputArea.append("Completed: " + customerID + " at " + slotTime.format(dtf) + "\n");
        updateCalendar();
    }

    private void handleCancel(LocalDateTime slotTime) {
        String customerID = JOptionPane.showInputDialog(frame, "Enter Customer ID to cancel:");
        if (customerID == null || customerID.isEmpty()) return;

        // Cancel the appointment, promote from waitlist automatically
        management.cancelAppointment(customerID, slotTime);
        outputArea.append("Cancelled appointment: " + customerID + " at " + slotTime.format(dtf) + "\n");

        // Immediately refresh calendar so both schedule and waitlist update
        updateCalendar();

        // Optional: print current slot status
        List<String> customerNames = management.getCustomerNamesForSlot(slotTime);
        int waitlistCount = management.getWaitlistMap().containsKey(slotTime)
                ? management.getWaitlistMap().get(slotTime).size() : 0;

        if (!customerNames.isEmpty())
            outputArea.append("Now scheduled: " + customerNames.get(0) + " (" + waitlistCount + " on waitlist)\n");
        else if (waitlistCount > 0)
            outputArea.append("Slot is now empty, waitlist: " + waitlistCount + "\n");
        else
            outputArea.append("Slot is now available.\n");


        updateCalendar();
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConsultantWeeklyGUI();
            }
        });
    }
}
