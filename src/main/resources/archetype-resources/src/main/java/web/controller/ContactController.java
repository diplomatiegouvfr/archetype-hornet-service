#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import ${package}.business.service.MailContactService;
import ${package}.web.dto.contact.ContactEnvoyerDTOIn;

/**
 * @author MAEDI
 * @since 1.0 - 3 févr. 2015
 */
@RestController
@RequestMapping(value = "/contact", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ContactController {

    @Resource
    private MailContactService mailContactService;

    @RequestMapping(value = "/envoyer", consumes = MediaType.APPLICATION_JSON_VALUE,
                method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void envoyerMail(@RequestBody final ContactEnvoyerDTOIn mail) {

        mailContactService.envoyerMail(mail.getNom(), mail.getPrenom(), mail.getMail(), mail.getMessage());
    }

}
