package com.suleimanov.vehiclecontrol.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPrincipalController {

  @GetMapping("/users_principals")
  public String getUserPrincipal() {
    return "user_principal";
  }
}