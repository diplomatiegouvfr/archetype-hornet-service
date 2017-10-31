#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.bo;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public final class Role {
    /** administrateur */
    public static final String ADMIN = "ROLE_${artifactId}_ADMIN";

    /** utilisateur */
    public static final String USER = "ROLE_${artifactId}_USER";

    /** Classe utilitaire => Constructeur privé */
    private Role() {
        // not called
    }
    
    /**
    *
    */
    private Long id;

    /**
     * Le nom du rôle
     */
    private String name;

    /**
     * @return id
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id
     *            id
     */
    public void setId(final Long id) {

        this.id = id;
    }

    /**
     * @return nom
     */
    public String getName() {

        return name;
    }

    /**
     * @param nom
     *            nom
     */
    public void setName(final String name) {

        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Role [id=").append(id).append(", name=").append(name).append("]");
        return builder.toString();
    }
}