package view.gui;

import view.Event_Name;
import view.interfaces.I_Gui_Window;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Gui_Window extends JFrame implements I_Gui_Window {
    private final Insets default_Button_Dimensions
            = new Insets(5, 8, 5, 8);
    private final Map<Event_Name, JButton> event_Buttons = new HashMap<>();

    public Gui_Window(Paint_Canvas canvas) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String defaultTitle = "JPaint";
        setTitle(defaultTitle);
        int defaultWidth = 1200;
        int defaultHeight = 800;
        setSize(defaultWidth, defaultHeight);
        JPanel window = createWindow();
        window.add(canvas, BorderLayout.CENTER);
        validate();
    }

    @Override
    public JButton get_Button(Event_Name event_Name) {
        if (!event_Buttons.containsKey(event_Name))
            throw new NoSuchElementException("No button exists for action " + event_Name.toString());

        return event_Buttons.get(event_Name);
    }

    private JPanel createWindow() {
        JPanel content_Pane = create_Background_Panel();
        JPanel button_Panel = create_Menu();
        content_Pane.add(button_Panel, BorderLayout.NORTH);
        return content_Pane;
    }

    private JPanel create_Menu() {
        JPanel button_Panel = create_Button_Panel();

        for (Event_Name event_Name : Event_Name.values()) {
            addButtonToPanel(event_Name, button_Panel);
        }

        return button_Panel;
    }

    private void addButtonToPanel(Event_Name event_Name, JPanel panel) {
        JButton new_Button = create_Button(event_Name);
        event_Buttons.put(event_Name, new_Button);
        panel.add(new_Button);
    }

    private JButton create_Button(Event_Name event_Name) {
        JButton new_Button = new JButton(event_Name.toString());
        new_Button.setForeground(Color.BLACK);
        new_Button.setBackground(Color.WHITE);
        new_Button.setBorder(create_Button_Border());
        return new_Button;
    }

    private Border create_Button_Border() {
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(default_Button_Dimensions);
        return new CompoundBorder(line, margin);
    }

    private JPanel create_Button_Panel() {
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.setBackground(Color.lightGray);
        return panel;
    }

    private JPanel create_Background_Panel() {
        JPanel content_Pane = new JPanel();
        content_Pane.setBorder(new EmptyBorder(0, 0, 0, 0));
        content_Pane.setLayout(new BorderLayout(0, 0));
        content_Pane.setBackground(Color.WHITE);
        setContentPane(content_Pane);
        return content_Pane;
    }
}
