package org.joseph.Controller;

import org.joseph.Component.CreateRealEstateModal;
import org.joseph.View.RealEstateView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealEstateController {
    private final RealEstateView view;

    public RealEstateController(RealEstateView view) {
        this.view = view;

        view.getAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateRealEstateModal modal = new CreateRealEstateModal();
                modal.setVisible(true);
            }
        });
    }



    public RealEstateView getView() {
        return view;
    }
}
