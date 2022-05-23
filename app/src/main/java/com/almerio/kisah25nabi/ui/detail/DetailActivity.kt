package com.almerio.kisah25nabi.ui.detail

import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.almerio.kisah25nabi.R
import com.almerio.kisah25nabi.data.KisahResponse
import com.almerio.kisah25nabi.databinding.ActivityDetailBinding
import com.almerio.kisah25nabi.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)
        data?.let {
            binding.apply {
                Glide.with(this@DetailActivity).load(data.imageUrl).into(detailImage)
                detailNama.text = data.name
                val tahun = "Tahun Kelahiran: " + data.thnKelahiran
                detailTahun.text = tahun
                detailTempat.text = data.tmp
                val usia = "Usia: " + data.usia + " tahun"
                detailUsia.text = usia
                detailDesk.text = data.description
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }
}

