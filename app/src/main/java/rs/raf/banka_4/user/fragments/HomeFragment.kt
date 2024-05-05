package rs.raf.banka_4.user.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import rs.raf.banka_4.databinding.FragmentHomeBinding

class HomeFragment:Fragment(){
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        //TODO ulepsaj stvari i ispovezuj hvala
    }

    private fun init(){
        val handler = Handler(Looper.getMainLooper())
        val add = binding.fragmentHomeAdd
        val kreditVise = binding.fragmentHomeSaznajVise
        val kreditAdd = binding.fragmentHomeKreditReklama
        add.visibility = View.GONE
        kreditVise.visibility = View.GONE
        handler.postDelayed({
            add.visibility = View.VISIBLE
            kreditVise.visibility = View.VISIBLE
        },5000)

        kreditVise.setOnClickListener{
            kliknoNaKreditKreten()
        }
        kreditAdd.setOnClickListener{
            kliknoNaKreditKreten()
        }
        val x = binding.fragmentHomeExitAdd
        x.setOnClickListener{
            add.visibility = View.GONE
            kreditVise.visibility = View.GONE
            handler.postDelayed({
                kreditAdd.isClickable = true
                add.visibility = View.VISIBLE
                kreditVise.visibility = View.VISIBLE
            },10000)
        }
    }
    private fun kliknoNaKreditKreten(){
        Toast.makeText(this.context,"Zelis li kredit",Toast.LENGTH_SHORT).show()
    }

}