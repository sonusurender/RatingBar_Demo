package com.android_ratingbar_demo;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private static RatingBar ratingbar_default, getRatingBar, setRatingBar;
	private static TextView ratingValue_default, setcountText;
	int count;
	float curRate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setListeners();
	}

	// Initializing the views
	void init() {

		ratingbar_default = (RatingBar) findViewById(R.id.ratingbar_default);
		getRatingBar = (RatingBar) findViewById(R.id.getRatings);
		setRatingBar = (RatingBar) findViewById(R.id.setRatings);
		ratingValue_default = (TextView) findViewById(R.id.ratingbar_default_number);
		setcountText = (TextView) findViewById(R.id.setcountText);

	}

	// Setting listeners on ratinbars
	void setListeners() {

		// Ratingbar default
		ratingbar_default
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float rating, boolean fromUser) {

						// Get currnet rating
						String ratedValue = String.valueOf(rating);

						// Get Number of stars
						int numStars = ratingBar.getNumStars();

						// Now set the rated Value and numstars on textView
						ratingValue_default.setText("Rating value is : "
								+ ratedValue + "/" + numStars);
					}
				});

		// GetRatingBar
		getRatingBar
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float rating, boolean fromUser) {

						// Decimal format for converting all floats into decimal
						DecimalFormat decimalFormat = new DecimalFormat("#.#");

						// Get Current rating
						curRate = Float.valueOf(decimalFormat.format((curRate
								* count + rating)
								/ ++count));

						// Showing a toast of current rating
						Toast.makeText(MainActivity.this,
								"New Rating: " + curRate, Toast.LENGTH_SHORT)
								.show();

						// Set the current rating to setRatingBar
						setRatingBar.setRating(curRate);

						// Show the current count value
						setcountText.setText(count + " Ratings");

					}
				});
	}

}
