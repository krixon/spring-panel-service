package com.krixon.panelservice.controller;

import com.krixon.panelservice.dto.Panel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PanelController {

    @RequestMapping("/panels")
    @PreAuthorize("#oauth2.hasScope('panel:read')")
    public ArrayList<Panel> getPanelList() {

        // TODO: Real persistence.

        ArrayList<Panel> panels = new ArrayList<>();

        panels.add(new Panel("1", "Foo Panel"));
        panels.add(new Panel("2", "Bar Panel"));
        panels.add(new Panel("3", "Baz Panel"));

        return panels;
    }
}