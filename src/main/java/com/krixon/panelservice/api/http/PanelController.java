package com.krixon.panelservice.api.http;

import com.krixon.panelservice.application.dto.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PanelController {

    private final OAuth2ClientContext clientContext;

    @Autowired
    public PanelController(OAuth2ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    @RequestMapping("/panels")
    public ArrayList<Panel> getPanelList() {

        OAuth2AccessToken token = clientContext.getAccessToken();

        System.out.println(token);

        // TODO: Real persistence.

        ArrayList<Panel> panels = new ArrayList<>();

        panels.add(new Panel("1", "Foo Panel"));
        panels.add(new Panel("2", "Bar Panel"));
        panels.add(new Panel("3", "Baz Panel"));

        return panels;
    }
}
