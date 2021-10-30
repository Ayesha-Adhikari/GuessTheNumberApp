package com.ayesha.guessthenumber;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class successDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        GameActivity gm = new GameActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("SUCCESS")
                .setMessage("You made it in " + gm.steps + " guesses!")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
        return builder.create();
    }
}
