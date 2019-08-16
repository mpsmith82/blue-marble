package hellofx;

import org.curiousworks.BlueMarble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueMarbleController {

	@FXML
	private ImageView image;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Label errorLabel;

	@FXML
	private CheckBox enhancedImage;

	@FXML
	private CheckBox blackAndWhite;

	// -----------------------------------------------------

	@FXML
	void updateDate(ActionEvent event) {

		try {

			errorLabel.setText("");

			BlueMarble blueMarble = new BlueMarble();

			blueMarble.setDate(datePicker.getValue().getYear() + "-0" + datePicker.getValue().getMonthValue() + "-"
					+ datePicker.getValue().getDayOfMonth());

			// ---------------------------------------------

			if (datePicker.getValue().getYear() >= 2018 && datePicker.getValue().getMonthValue() >= 7) {

				enhancedImage.setDisable(true);

			} // end if

			else {

				enhancedImage.setDisable(false);

			} // end else

			// ---------------------------------------------

			blueMarble.setEnhanced(enhancedImage.isSelected());

			image.setImage(new Image(blueMarble.getImage()));

			// ---------------------------------------------

			ColorAdjust ca = new ColorAdjust();

			if (blackAndWhite.isSelected()) {

				ca.setSaturation(-1);

			} // end if

			else {

				ca.setSaturation(0.0);

			} // end else

			image.setEffect(ca);

			errorLabel.setText("Successful Date/Load");

		} // end try

		catch (Exception ex) {

			errorLabel.setText("Could Not Load");

			image.setImage(null);

		} // end catch

	}// end updateDate

}// end class
