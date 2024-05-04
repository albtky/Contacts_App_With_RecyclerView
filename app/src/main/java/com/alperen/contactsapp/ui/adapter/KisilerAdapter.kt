package com.alperen.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alperen.contactsapp.data.entity.Kisiler
import com.alperen.contactsapp.databinding.CardviewBinding
import com.alperen.contactsapp.databinding.FragmentAnasayfaBinding
import com.alperen.contactsapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisilerListesi: List<Kisiler>) :
    RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardviewBinding) :
        RecyclerView.ViewHolder(tasarim.root)
// xml tasarımına ulaştığımız kısım
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding= CardviewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }
// elimizdeki tasarım ile yapacağımız işlemler
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
    val t = holder.tasarim

    t.textViewKisiAd.text=kisi.kisi_ad
    t.textViewKisiTel.text=kisi.kisi_tel

    t.cardViewSatir.setOnClickListener{
        val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi=kisi)
        Navigation.findNavController(it).navigate(gecis)
    }
    t.imageViewSil.setOnClickListener {
        Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ? ",Snackbar.LENGTH_SHORT)
            .setAction("EVET")
        {
            sil(kisi.kisi_id)
        }.show()
    }

    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
    fun sil(kisi_id:Int)
    {
        Log.e("Kişi Sil",kisi_id.toString())
    }
}