package com.krixon.panelservice.controller;

import brave.Span;
import brave.Tracer;
import com.krixon.panelservice.dto.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PanelController
{
    @Autowired
    private Tracer tracer;

    @RequestMapping("/panels")
    @PreAuthorize("#oauth2.hasScope('panel:read')")
    public ArrayList<Panel> getPanelList()
    {
        // TODO: Real persistence.

        ArrayList<Panel> panels = new ArrayList<>();

        Span span = tracer
            .nextSpan()
            .name("fetch panel list")
            .kind(Span.Kind.SERVER)
            .start();

        try {
            panels.add(new Panel("1", "David Lister Appreciation Society"));
            panels.add(new Panel("2", "Beef and Dairy Network"));
            panels.add(new Panel("3", "Some Panel Name"));
        } finally {
            span.finish();
        }

        return panels;
    }
}
