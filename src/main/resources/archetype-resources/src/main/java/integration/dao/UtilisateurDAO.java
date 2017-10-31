#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.integration.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import ${package}.business.bo.Utilisateur;

/**
 * Classe DAO pour les entités Utilisateur
 * 
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class UtilisateurDAO extends SqlSessionDaoSupport {

    /**
     * Constructeur
     */
    public UtilisateurDAO() {

        super();
    }
    
    public Utilisateur selectById(final Long utiId) {

        final Map<String, String> params = new HashMap<String, String>();
        params.put("utiId", utiId.toString());
        return this.getSqlSession().selectOne("utilisateur.selectById", params);
    }

    public Utilisateur selectByLogin(final String login) {

        final Map<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        return this.getSqlSession().selectOne("utilisateur.selectByLogin", params);
    }

    public Utilisateur selectByLoginPassword(final String login, final String passwordEncrypted) {

        final Map<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("password", passwordEncrypted);
        return this.getSqlSession().selectOne("utilisateur.selectByUserPassword", params);
    }
}
