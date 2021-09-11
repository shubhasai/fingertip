package `in`.vikins.fingertip

import `in`.vikins.fingertip.databinding.ActivityHomeBinding
import `in`.vikins.fingertip.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navhost = supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        binding.navmenu.setupWithNavController(navhost.navController)
    }
}