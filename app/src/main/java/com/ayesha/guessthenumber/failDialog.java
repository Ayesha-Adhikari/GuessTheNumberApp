package com.ayesha.guessthenumber;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class failDialog extends AppCompatDialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        GameActivity gm = new GameActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("FAILED!!")
                .setMessage("You already tried " + gm.steps + " times!")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
        return builder.create();
    }
}
