package com.neosmart.socio_infonavit_android.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;
import com.neosmart.socio_infonavit_android.Interface.Inter_Login;
import com.neosmart.socio_infonavit_android.Modelos.InputTypeItem;
import com.neosmart.socio_infonavit_android.Presenter.Presen_Login;
import com.neosmart.socio_infonavit_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link View_Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class View_Login extends Fragment implements Inter_Login.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Presen_Login PLogin ;
    EditText user ;
    EditText password;
    TextView text_response;
    Button btnIngresar;
    TextInputLayout texFielCorreoEectronico, texFielPassword;

    String CorreoIngresado;
    String PasswordIngresado;
    InputTypeItem inputTypes;
        boolean banderacorreo =false;
        boolean banderacontraseña= false;
        String cadenaDatos="";
        String estructuraCadena ="";

    boolean valor = false ;
    private SharedPreferences sharedPreferences;
    public View_Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment View_Login.
     */
    // TODO: Rename and change types and number of parameters
    public static View_Login newInstance(String param1, String param2) {
        View_Login fragment = new View_Login();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        PLogin = new Presen_Login(this);
        View v= inflater.inflate(R.layout.fragment_view__login, container, false);
        user = v.findViewById(R.id.input_email);
        password = v.findViewById(R.id.input_password);
        inputTypes = new InputTypeItem("textEmailAddress",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        user.setInputType(inputTypes.value);

        btnIngresar = v.findViewById(R.id.btn_signup);
        btnIngresar.setEnabled(false);
        texFielCorreoEectronico = v.findViewById(R.id.texFielUser);
        texFielPassword = v.findViewById(R.id.texFielPassword);
        password.setTransformationMethod(null);
        sharedPreferences = this.getActivity().getSharedPreferences("Datos", Context.MODE_PRIVATE);

        user.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction()!=KeyEvent.ACTION_DOWN ) && (keyCode == event.KEYCODE_ENTER)){
                  // Toast.makeText(getContext(), " enter user", Toast.LENGTH_SHORT).show();
                    password.findFocus();

                }
                validarinputs();
                return false;
            }
        });


       password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                validarinputs();
                if ((event.getAction()!=KeyEvent.ACTION_DOWN ) && (keyCode == event.KEYCODE_ENTER)){

                //    Toast.makeText(getContext(), " enter pass", Toast.LENGTH_SHORT).show();
                    try {
                        btnIngresar.setEnabled(false);
                        PLogin.EnviaDatosLogin(user.getText().toString().trim(),password.getText().toString().trim());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //valor=true;
                  //  validarinputs();

                }

                return false;
            }
        });


       validarCampos();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
btnIngresar.setEnabled(false);
                    PLogin.EnviaDatosLogin(user.getText().toString().trim(),password.getText().toString().trim());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        return v;
    }

    private void validarCampos() {
        user.addTextChangedListener(new MyTextWatcher(user));
        password.addTextChangedListener(new MyTextWatcher(password));

    }
   private void llamarwebservice(){

   }
   private void validarinputs(){
       if (password.getText().toString().trim().equals("") || user.getText().toString().trim().equals("")){
           System.out.println ("alguno esta vacio" );
           btnIngresar.setEnabled(false);
       }
       else {
           System.out.println ("Mningyno esta vacio  " );
           btnIngresar.setEnabled(true);
       }
   }

    @Override
    public void MostrarResultadosLogin(int code, String respuesta) {
        System.out.println ("MostrarResultadosLogin Authorization " + respuesta);
        System.out.println ("MostrarResultadosLogin code " + code);

        if (code==200){
            SharedPreferences.Editor autorizacion = sharedPreferences.edit();
            autorizacion.putString("Authorization", respuesta);
            autorizacion.apply();

            View_Benevits BeneViewBenevits= new View_Benevits();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//comenzamos transacción
            fragmentTransaction.replace(R.id.fragment_container, BeneViewBenevits);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if(code==404){
            Toast.makeText(getContext(), respuesta, Toast.LENGTH_SHORT).show();
            btnIngresar.setEnabled(true);
        }
        else {

            btnIngresar.setEnabled(true);
        String mensaje =   "Usuario y contraseña incorrectos intente de nuevo.";
            AlertDialog.Builder builder
                    = new AlertDialog
                    .Builder(getContext());
            builder.setMessage(mensaje);
            builder.setCancelable(false);
            builder
                    .setPositiveButton(
                            "Aceptar",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which)
                                {

                                    dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = builder.create();

            alertDialog.show();
        }
    }


    private class MyTextWatcher implements TextWatcher {
        View view;

        private MyTextWatcher(View view) {
            // Log.i(TAG, "MyTextWatcher Constructor: fired");
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (password.getText().toString().trim().equals("") || user.getText().toString().trim().equals("")){
                System.out.println ("alguno esta vacio" );
                btnIngresar.setEnabled(false);
            }
            else {
                System.out.println ("Mningyno esta vacio  " );
                if (banderacontraseña && banderacorreo){
                    btnIngresar.setEnabled(true);
                }else {
                    btnIngresar.setEnabled(false);
                }

            }


        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //    Log.i(TAG, "onTextChanged: fired");

            switch (view.getId()) {


                case R.id.input_email:
                    texFielCorreoEectronico.setErrorEnabled(Boolean.TRUE);

                    break;
                case R.id.input_password:
                    texFielPassword.setErrorEnabled(Boolean.TRUE);
                    break;
            }
            if (password.getText().toString().trim().equals("") || user.getText().toString().trim().equals("")){
                System.out.println ("alguno esta vacio" );
                btnIngresar.setEnabled(false);
            }
            else {
                System.out.println ("Mningyno esta vacio  " );
                if (banderacontraseña && banderacorreo){
                    btnIngresar.setEnabled(true);
                }else {
                    btnIngresar.setEnabled(false);
                }
            }


        }

        @Override
        public void afterTextChanged(Editable editable) {
            //  Log.i(TAG, "afterTextChanged: fired");

            switch (view.getId()) {


                case R.id.input_email:
                    String email = user.getText().toString().trim();
                    if (email.isEmpty() || !isValidEmail(email)) {


                        texFielCorreoEectronico.setError(getResources().getString(R.string.error_correo));
                        banderacorreo=false;
                    } else {

                        texFielCorreoEectronico.setErrorEnabled(Boolean.FALSE);
                        CorreoIngresado = user.getText().toString().trim();
                        banderacorreo=true;

                    }


                    break;
                case R.id.input_password:

                    String passwor= password.getText().toString().trim();
                    if (passwor.isEmpty()) {

                        texFielPassword.setError(getResources().getString(R.string.error_contrasena));
                        banderacontraseña=false;

                    } else {
                        texFielPassword.setErrorEnabled(Boolean.FALSE);
                        PasswordIngresado = password.getText().toString().trim();
                        banderacontraseña=true;
                    }


                    break;
            }



        }
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }



}