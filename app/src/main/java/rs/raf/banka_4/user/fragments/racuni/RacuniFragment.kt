package rs.raf.banka_4.user.fragments.racuni

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import rs.raf.banka_4.R
import rs.raf.banka_4.databinding.FragmentRacuniBinding

class RacuniFragment:Fragment() {
    private lateinit var binding: FragmentRacuniBinding
    private var lastChecked = -1
    private lateinit var currentFragment: Fragment
    private lateinit var handler:Handler

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRacuniBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        //TODO ulepsaj stvari i ispovezuj hvala
    }



    private fun init(){
        handler = Handler(Looper.getMainLooper())
        val transakcijeFragment = TransakcijaFragment()
        var detaljiRacunaFragment = DetaljiRacunaFragment()
        var fragmentRacuniFrame = binding.fragmentRacuniFrame
        val toggleDetaljiRacuna = binding.racuniToggleDetalji
        val togleTransakcije = binding.racuniToggleTransakcije


        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(fragmentRacuniFrame.id,detaljiRacunaFragment)
            commit()
        }
        currentFragment = detaljiRacunaFragment


        toggleDetaljiRacuna.isChecked = true
        toggleDetaljiRacuna.isClickable = false
        lastChecked = toggleDetaljiRacuna.id
        toggleDetaljiRacuna.setOnCheckedChangeListener{buttonView,ischecked ->
            if(ischecked){
                if(lastChecked != buttonView.id){
                    toggleDetaljiRacuna.isClickable = false
                    togleTransakcije.isClickable = true
                    togleTransakcije.isChecked = false
                    lastChecked = buttonView.id

                    requireActivity().supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.enter_from_left, R.anim.exit_to_right,
                            R.anim.enter_from_right, R.anim.exit_to_left
                        )
                        .replace(fragmentRacuniFrame.id, detaljiRacunaFragment)
                        .commit()

                }
            }
        }

        togleTransakcije.setOnCheckedChangeListener{buttonView,ischecked ->
            if(ischecked){
                if(lastChecked != buttonView.id){
                    togleTransakcije.isClickable = false
                    toggleDetaljiRacuna.isClickable = true
                    toggleDetaljiRacuna.isChecked = false
                    lastChecked = buttonView.id
                    requireActivity().supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.enter_from_right, R.anim.exit_to_left,
                            R.anim.enter_from_left, R.anim.exit_to_right
                        )
                        .replace(fragmentRacuniFrame.id, transakcijeFragment)
                        .commit()
                }
            }
        }

    }

}