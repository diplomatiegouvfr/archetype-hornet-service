#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.bo;

/**
 * @author MAEDI
 */
public final class Role {
    /** administrateur */
    public static final String ADMIN = "ROLE_AppliTuto_ADMIN";

    /** utilisateur */
    public static final String USER = "ROLE_AppliTuto_USER";

    /** Classe utilitaire => Constructeur privé */
    private Role() {
        // not called
    }
}