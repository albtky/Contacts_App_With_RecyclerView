package com.alperen.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.alperen.contactsapp.R
import com.alperen.contactsapp.data.entity.Kisiler
import com.alperen.contactsapp.databinding.FragmentAnasayfaBinding
import com.alperen.contactsapp.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.rv.layoutManager= LinearLayoutManager(requireContext())
        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"ahmet","1111")
        val k2 = Kisiler(2,"alperen","2222")
        val k3 = Kisiler(3,"alp","3111")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        val kisilerAdapter= KisilerAdapter(requireContext(),kisilerListesi)
        binding.rv.adapter=kisilerAdapter


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }
        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                ara(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                ara(newText!!)
                return true
            }

        })


        return binding.root
    }
    fun ara ( aramaKelimesi:String)
    {
        Log.e("Kişi Ara", aramaKelimesi)
    }
}