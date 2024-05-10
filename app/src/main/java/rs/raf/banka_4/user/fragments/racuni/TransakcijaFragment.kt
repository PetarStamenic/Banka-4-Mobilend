package rs.raf.banka_4.user.fragments.racuni

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import rs.raf.banka_4.databinding.FragmentTransakcijeRecyclerBinding

class TransakcijaFragment: Fragment() {
    private lateinit var binding: FragmentTransakcijeRecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransakcijeRecyclerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO ulepsaj stvari i ispovezuj hvala
    }
}