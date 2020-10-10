package com.example.roomwithexoplayer.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.roomwithexoplayer.R
import com.example.roomwithexoplayer.ui.base.ViewModelFactory
import com.example.roomwithexoplayer.ui.main.adapter.RecyclerViewAdapter
import com.example.roomwithexoplayer.ui.main.viewModel.HomeDataViewModel
import kotlinx.android.synthetic.main.home_screen.*

class HomeScreenActivity : AppCompatActivity() {

    lateinit var homeDataViewModel: HomeDataViewModel
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        setUpViewModel()
        sendDataToRecyclerView()

        homeDataViewModel.setDataToLiveData().observe(this, Observer {
            recyclerViewAdapter.updateData(it)
        })
    }
    private fun sendDataToRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter(emptyList()) { view, position ->
            openPlayerActivity()
        }

        recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            recyclerView.adapter = recyclerViewAdapter
        }
    }
    private fun setUpViewModel() {
        homeDataViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(this)
        ).get(HomeDataViewModel::class.java)
    }

    private fun openPlayerActivity(){
        val intent = Intent(this,ExoPlayerActivity::class.java)
        startActivity(intent)
    }


}