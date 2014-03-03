package controllers

import models._
import views._

import play.api.mvc.{Action, Controller}
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._

object Contacts extends Controller {

  /**
   * Contact Form definition
   */
  val contactForm: Form[Contact] = Form(

    // Defines a mapping that will handle Contact values
    mapping(
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText,
      "company" -> optional(text),

      // Defines a repeated mapping
      "informations" -> seq(
        mapping(
          "label" -> nonEmptyText,
          "email" -> optional(email),
          "phones" -> list(
            text verifying pattern ("""[0-9.+]""".r, error="a valid phone number is required")
          )
        )(ContactInformation.apply)(ContactInformation.unapply)
      )
    )(Contact)(Contact.unapply)
  )

  /**
   * Display an empty form
   */
  def form = Action {
    Ok(html.contact.form(contactForm))
  }

  /**
   * Display a form pre-filled with an existing contact
   */
  def editForm = Action {
    val existingContact = Contact(
      "Fake", "Contact", Some("Fake company"), informations = List(
        ContactInformation(
          "Personal", Some("fakecontact@gmail.com"), List("01.23.45.67.89", "98.76.54.32.10")
        ),
        ContactInformation(
          "Professional", Some("facecontact@company.com"), List("01.23.45.67.89")
        ),
        ContactInformation(
          "Previous", Some("facecontact@oldcompany.com"), List()
        )
      )
    )
    Ok(html.contact.form(contactForm.fill(existingContact)))
  }

  /**
   * Handle form submission
   */
  def submit = Action { implicit request =>
    contactForm.bindFromRequest.fold(
      errors => BadRequest(html.contact.form(errors)),
      contact => Ok(html.contact.summary(contact))
    )
  }

}
