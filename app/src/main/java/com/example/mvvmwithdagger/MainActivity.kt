package com.example.mvvmwithdagger

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithdagger.di.appComponent
import com.example.mvvmwithdagger.resource.Status
import com.example.mvvmwithdagger.viewmodel.MyViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MyViewModel by viewModels { viewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        appComponent().inject(this)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.btn)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.isVisible = false
        progressBar.isActivated = false
        btn.setOnClickListener {
            viewModel.token()
        }
        viewModel.tokenState().observe(this) { resource ->
            progressBar.isVisible = resource.status == Status.LOADING
            progressBar.isActivated = resource.status == Status.LOADING
            if (resource.status == Status.SUCCESS) {
                btn.isVisible = false
                println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>${viewModel.getClientSecret()}")
            } else if (resource.status == Status.ERROR) {
                Toast.makeText(this, "${resource.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}