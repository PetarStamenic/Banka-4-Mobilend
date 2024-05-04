package rs.raf.banka_4.login

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rs.raf.banka_4.R
import rs.raf.banka_4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var lastChecked:Int = -1;
    //TODO bilo bi lepo napraviti gesture recogniser da radi sa butonima


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pravnaButton = binding.activityLoginTogglePravna
        val fizickaButton = binding.activityLoginToggleFizicka
        val topText = binding.activityLoginTextView
        val mainConstraintLayout = binding.activityLoginInnerConstraint
        val buttonGroup = binding.activityLoginLinearLayout
        val lica = binding.activityLoginTextLica
        val username = binding.activityLoginUsername
        val password = binding.activityLoginPassword
        lastChecked = fizickaButton.id
        fizickaButton.isClickable = false


        // Set color for the top status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            // Set color for lower versions
        }

        // Set color for the bottom navigation bar if supported
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            window.navigationBarColor = resources.getColor(R.color.white)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            window.statusBarColor = resources.getColor(R.color.loading)
        }

        fizickaButton.setOnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                if(lastChecked != buttonView.id){
                    fizickaButton.isClickable = false
                    pravnaButton.isClickable = true
                    pravnaButton.isChecked = false
                    lastChecked = buttonView.id
                    //BANKA-4
                    topText.setTextColor(getResources().getColor(R.color.golden,theme))
                    topText.setBackgroundColor(getResources().getColor(R.color.loading,theme))
                    //Fade background
                    mainConstraintLayout.setBackgroundResource(R.drawable.fade_background_red)
                    //Button group
                    buttonGroup.setBackgroundResource(R.drawable.linear_toggle_buttons_background_red)
                    //Za stanovnistvo
                    lica.setText(R.string.stanovnistvo)
                    //username
                    username.setBackgroundResource(R.drawable.round_edit_text_golden)
                    //password
                    password.setBackgroundResource(R.drawable.round_edit_text_golden)
                    //statusbar
                    window.statusBarColor = resources.getColor(R.color.loading)
                }
        }}

        pravnaButton.setOnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                if(lastChecked != buttonView.id){
                    fizickaButton.isClickable = true
                    pravnaButton.isClickable = false
                    fizickaButton.isChecked = false
                    lastChecked = buttonView.id

                    //BANKA-4
                    topText.setTextColor(getResources().getColor(R.color.loading,theme))
                    topText.setBackgroundColor(getResources().getColor(R.color.golden,theme))
                    //Fade background
                    mainConstraintLayout.setBackgroundResource(R.drawable.fade_background_golden)
                    //Button group
                    buttonGroup.setBackgroundResource(R.drawable.linear_toggle_buttons_background_golden)
                    //Za stanovnistvo
                    lica.setText(R.string.biznis)
                    //username
                    username.setBackgroundResource(R.drawable.rounde_edit_text_red)
                    //password
                    password.setBackgroundResource(R.drawable.rounde_edit_text_red)
                    //statusbar
                    window.statusBarColor = resources.getColor(R.color.golden)
                }
            }
        }
    }
}
