/**
 * ﻿Copyright Ministère des Affaires étrangères et du Développement international , 22 avril 2015
 * https://adullact.net/projects/hornet/
 *
 *
 * Ce logiciel est un programme informatique servant à faciliter la création
 *  d'applications Web accessibles conforémement au RGAA et performantes.
 *
 * Ce logiciel est régi par la licence CeCILL v2.1 soumise au droit français et
 * respectant les principes de diffusion des logiciels libres. Vous pouvez
 * utiliser, modifier et/ou redistribuer ce programme sous les conditions
 * de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA
 * sur le site "http://www.cecill.info".
 *
 * En contrepartie de l'accessibilité au code source et des droits de copie,
 * de modification et de redistribution accordés par cette licence, il n'est
 * offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
 * seule une responsabilité restreinte pèse sur l'auteur du programme,  le
 * titulaire des droits patrimoniaux et les concédants successifs.
 *
 * A cet égard  l'attention de l'utilisateur est attirée sur les risques
 * associés au chargement,  à l'utilisation,  à la modification et/ou au
 * développement et à la reproduction du logiciel par l'utilisateur étant
 * donné sa spécificité de logiciel libre, qui peut le rendre complexe à
 * manipuler et qui le réserve donc à des développeurs et des professionnels
 * avertis possédant  des  connaissances  informatiques approfondies.  Les
 * utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
 * logiciel à leurs besoins dans des conditions permettant d'assurer la
 * sécurité de leurs systèmes et ou de leurs données et, plus généralement,
 * à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.
 *
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez
 * pris connaissance de la licence CeCILL, et que vous en avez accepté les
 * termes.
 */
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import hornet.framework.exception.AuthenticationFailedException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ${package}.business.bo.Role;
import ${package}.business.bo.Utilisateur;
import ${package}.business.service.RoleService;
import ${package}.business.service.UtilisateurService;
import ${package}.web.dto.utilisateur.AuthDTOIn;
import ${package}.web.dto.utilisateur.UtilisateurRolesDTO;
import ${package}.web.security.JwtService;
import ${package}.web.security.profile.User;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 * @since 1.0 - 3 févr. 2015
 */
@RestController
@RequestMapping(value = "/utilisateurs", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UtilisateurController {

    private static final Logger LOG = LoggerFactory.getLogger(UtilisateurController.class);

    @Resource
    private UtilisateurService utilisateurService;
    
    @Resource
    private JwtService jwtService;

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public UtilisateurRolesDTO authentifier(@RequestBody final AuthDTOIn dtoIn, HttpServletResponse  response) {

        LOG.debug("Demande d'authentification");

        final UtilisateurRolesDTO utilisateurRolesDTO = new UtilisateurRolesDTO();
        
        Utilisateur utilisateur = utilisateurService.lireUtilisateur(dtoIn.getLogin(),
                dtoIn.getPassword());


        if (utilisateur == null) {
            throw new AuthenticationFailedException();
        }
        
        utilisateurRolesDTO.setName(utilisateur.getLogin());

        utilisateurRolesDTO.setRoles(roleService.lireRoleParIdUtilisateur(utilisateur.getUtiId()));

        LOG.debug("Out authentification : {}", utilisateurRolesDTO.toString());
        
        User u = new User(utilisateur.getLogin());
        for (Role r : utilisateurRolesDTO.getRoles()) {
        	u.addRoles(r.getName());
		}
        
        response.setHeader("Authorization", "Bearer " + jwtService.signedAsymetricTokenFor(JwtService.USER_CLAIM, u));

        return utilisateurRolesDTO;
    }
}
