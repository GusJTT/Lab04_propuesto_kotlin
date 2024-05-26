package com.example.lab04_propuesto_kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class RegistroFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registro, container, false)

        val btnAceptar = view.findViewById<Button>(R.id.btnAceptar)
        val edtFirstname = view.findViewById<EditText>(R.id.edtFirstname)
        val edtLastname = view.findViewById<EditText>(R.id.edtLastname)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtPhone = view.findViewById<EditText>(R.id.edtPhone)
        val edtUsername2 = view.findViewById<EditText>(R.id.edtUsername2)
        val edtPassword2 = view.findViewById<EditText>(R.id.edtPassword2)

        btnAceptar.setOnClickListener {
            val account = AccountEntity()
            account.setFirstname(edtFirstname.text.toString())
            account.setLastname(edtLastname.text.toString())
            account.setEmail(edtEmail.text.toString())
            account.setPhone(edtPhone.text.toString())
            account.setUsername(edtUsername2.text.toString())
            account.setPassword(edtPassword2.text.toString())
            Log.d("RegistroFragment", "btnAceptarClick")
            enviarObjeto(account)
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }

    companion object {
        private lateinit var enviarObjeto: (AccountEntity) -> Unit
        @JvmStatic
        fun newInstance(enviarObjeto: (AccountEntity) -> Unit): RegistroFragment {
            Log.d("RegistroFragment", "newInstance")
            val registroFragment = RegistroFragment()
            this.enviarObjeto = enviarObjeto
            return registroFragment
        }
    }
}