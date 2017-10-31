#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import hornet.framework.exception.BusinessException;
import hornet.framework.mail.MailService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation pour l'envoi d'un mail de contact.
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class MailContactServiceImpl implements MailContactService {

    /** Recuperation du logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MailContactService.class);

    /** JavaMailSender. */
    private final transient MailService mailService;

    /** L'Objet du message de contact. */
    private final transient String objetContactMail;

    /** Le Corps du message de contact. */
    private final transient String corpsContactMail;

    /**
     * Les destinataires du mail de contact.
     */
    private final transient String[] destinataires;

    /** Nom de l'application. */
    private final transient String applicationName;

    /** Url de l'application. */
    private final transient String applicationUrl;

    /**
     * Constructeur par défaut.
     */
    public MailContactServiceImpl() {

        this.mailService = null;
        this.objetContactMail = null;
        this.corpsContactMail = null;
        this.destinataires = null;
        this.applicationName = null;
        this.applicationUrl = null;
    }

    /** Champ ReplyTo. */
    @SuppressWarnings("unused")
    private static final String NO_REPLY = "NoReply";

    /**
     * Constructeur.
     *
     * @param mailService
     *            Hornet MailService
     * @param applicationUrl
     *            Url de l'application
     * @param applicationName
     *            Nom de l'application
     * @param objetContactMail
     *            Objet du message de contact
     * @param corpsContactMail
     *            Corps du message de contact
     * @param destinataires
     *            Les destinataires du mail de contact
     */
    public MailContactServiceImpl(
                final MailService mailService, final String applicationUrl, final String applicationName,
                final String objetContactMail, final String corpsContactMail, final String[] destinataires) {

        this.mailService = mailService;
        this.applicationUrl = applicationUrl;
        this.applicationName = applicationName;
        this.objetContactMail = objetContactMail;
        this.corpsContactMail = corpsContactMail;
        this.destinataires = destinataires.clone();
    }

    /** {@inheritDoc} */
    @Override
    public void envoyerMail(final String nom, final String prenom, final String fromAddress,
                final String message) {

        try {
            final String sujet =
                        String.format(this.objetContactMail, this.applicationName,
                            WordUtils.capitalize(prenom), WordUtils.capitalize(nom));

            final Map<String, Object> params = new HashMap<String, Object>();
            params.put("nom", WordUtils.capitalize(nom));
            params.put("prenom", WordUtils.capitalize(prenom));
            params.put("corps", message);
            final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 'à' HH:mm:ss", Locale.FRENCH);
            params.put("date", sdf.format(new Date()));
            params.put("applicationName", this.applicationName);
            params.put("applicationUrl", this.applicationUrl);

            // Exemple d'utilisation d'un NO_REPLY ou d'ajout d'un CC
            // params.put(MailServiceImpl.SMTP_HEADER_REPLYTO, NO_REPLY);
            // params.put(MailServiceImpl.SMTP_HEADER_CC, "root@localhost.com");

            this.mailService.envoyerDepuisModele(fromAddress, sujet, this.corpsContactMail, params,
                this.destinataires);

        } catch (final Exception e) {
            MailContactServiceImpl.LOGGER.error("Erreur lors de la tentative d'envoi de mail de contact.", e);
            throw new BusinessException("ERR-CODE-MAIL-001", e);
        }

    }

}
