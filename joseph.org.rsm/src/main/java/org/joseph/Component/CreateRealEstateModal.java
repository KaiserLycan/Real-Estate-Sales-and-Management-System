package org.joseph.Component;

import org.joseph.Model.Types.HouseType;
import org.joseph.Model.Types.LotType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreateRealEstateModal extends JDialog {
    private final JTextField blockField;
    private final JTextField lotField;
    private final JTextField lotSize;
    private final JTextField lotPrice;
    private final JComboBox<LotType> lotType;
    private final JComboBox<HouseType> addHouse;
    private final JButton create;


    public CreateRealEstateModal () {
        setTitle("Add Real Estate");
        setSize(new Dimension(500, 700));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        add(mainPanel);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        JLabel header = new JLabel("Add Real Estate");
        header.setFont(header.getFont().deriveFont(Font.BOLD, 25));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(header);
        mainPanel.add(headerPanel);
        mainPanel.add(Box.createVerticalStrut(10));


        blockField = new JTextField("Block No:");
        lotField = new JTextField("Lot No:");
        lotSize = new JTextField("Lot Size:");
        lotPrice = new JTextField("Lot Price:");
        lotType = new JComboBox<>(LotType.values());
        lotType.setName("Select Lot Type");
        addHouse = new JComboBox<>(HouseType.values());
        addHouse.setName("Select House:");
        create = new JButton("Add Real Estate");

        List<JComponent> components = new ArrayList<>();
        components.add(blockField);
        components.add(lotField);
        components.add(lotSize);
        components.add(lotPrice);
        components.add(lotType);
        components.add(addHouse);
        components.add(create);

        for(JComponent component : components) {
            component.setAlignmentX(Component.CENTER_ALIGNMENT);
            component.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            if(component instanceof JTextField) {
                JPanel labelWrapper = new JPanel();
                labelWrapper.setLayout(new BoxLayout(labelWrapper, BoxLayout.X_AXIS));
                JLabel label = new JLabel(((JTextField) component).getText());
                label.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
                label.setAlignmentX(Component.LEFT_ALIGNMENT);
                labelWrapper.add(label);
                mainPanel.add(labelWrapper);
                ((JTextField) component).setText("");
            }
            else if (component instanceof JComboBox<?>) {
                JPanel labelWrapper = new JPanel();
                labelWrapper.setLayout(new BoxLayout(labelWrapper, BoxLayout.X_AXIS));
                JLabel label = new JLabel(component.getName());
                label.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
                label.setAlignmentX(Component.LEFT_ALIGNMENT);
                labelWrapper.add(label);
                mainPanel.add(labelWrapper);
            }

            mainPanel.add(component);
            mainPanel.add(Box.createVerticalStrut(5));
        }

        setLocationRelativeTo(null);
    }

    public JTextField getBlockField() {
        return blockField;
    }

    public JTextField getLotField() {
        return lotField;
    }

    public JTextField getLotSize() {
        return lotSize;
    }

    public JTextField getLotPrice() {
        return lotPrice;
    }

    public JComboBox<LotType> getLotType() {
        return lotType;
    }

    public JComboBox<HouseType> getAddHouse() {
        return addHouse;
    }

    public JButton getCreate() {
        return create;
    }
}
