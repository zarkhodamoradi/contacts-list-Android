package com.example.contactslist;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class overridedArrayAdapter extends ArrayAdapter {
    private Context context  ;
    private int resource ;
    private ArrayList<Contact> contacts ;


    public overridedArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.context = context ;
        this.resource = resource ;
        this.contacts = contacts  ;
    }

    @Override
    public int getCount(){
        return contacts.size();

    }


    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = contacts.get(position);

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //for converting out layout we should use get system service
        convertView= inflater.inflate(resource, parent  , false);
        ViewHolder holder= new ViewHolder(convertView);
        holder.FillItem(contact);

        return convertView;
    }

    class ViewHolder{
    TextView txtFullName ;
    TextView txtPhoneNumber ;
    ImageView imgViewCall ;
    ImageView imgViewSms ;



        public ViewHolder(View convertView){

            txtFullName= convertView.findViewById(R.id.txtFullName);
            txtPhoneNumber= convertView.findViewById(R.id.txtPhoneNumber);
            imgViewCall = convertView.findViewById(R.id.imgViewCall);
            imgViewSms = convertView.findViewById(R.id.imgViewSms);


        }

        public void FillItem(Contact contact ){
            txtFullName.setText(contact.getFullName().toString());
            txtPhoneNumber.setText(contact.getPhoneNumber().toString());
            imgViewCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // this method is called for making a call.
                    // on below line we are calling an intent to make a call.
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    // on below line we are setting data to it.
                    callIntent.setData(Uri.parse("tel:" + contact.getPhoneNumber().toString()));

                    // on below line we are checking if the calling permissions are granted not.

                    if (ActivityCompat.checkSelfPermission(context,
                            android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    // at last we are starting activity.
                    startActivity(context, callIntent , null);
                }
            });

            imgViewSms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + contact.getPhoneNumber().toString()));
                    intent.putExtra("sms_body", "Enter your messaage");
                    startActivity(context,intent, null );
                }
            });

        }

    }




}
