package com.uzb.currency_convertor

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.uzb.currency_convertor.main.MainViewModel
import com.uzb.currency_convertor.utils.ConvertEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "TAG"
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getConvertRate("USD", "KRW", "20")
        lifecycleScope.launchWhenCreated {
            viewModel.conversion.collectLatest {
                when (it) {
                    ConvertEvent.Empty -> Unit
                    is ConvertEvent.Error -> Log.d(TAG, "onCreate:  ${it.errorMessage}")
                    ConvertEvent.Loading -> Unit
                    is ConvertEvent.Success -> Log.d(TAG, "onCreate: ${it.result}")
                }
            }
        }
    }
}