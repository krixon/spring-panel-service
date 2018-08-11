package com.krixon.panelservice.controller;

import brave.SpanCustomizer;
import com.krixon.panelservice.dto.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/panels")
public class PanelController
{
    private final SpanCustomizer span;

    @Autowired
    public PanelController(SpanCustomizer span)
    {
        this.span = span;
    }

    @RequestMapping("")
    @PreAuthorize("#oauth2.hasScope('panel:read')")
    public ArrayList<Panel> getPanelList()
    {
        // TODO: Real persistence.

        ArrayList<Panel> panels = new ArrayList<>();

        span.annotate("Fetch Panel List Start");

        panels.add(new Panel("1", "David Lister Appreciation Society"));
        panels.add(new Panel("2", "Beef and Dairy Network"));
        panels.add(new Panel("3", "Some Panel Name"));

        span.annotate("Fetch Panel List Finish");

        return panels;
    }
}
