package com.voteme.duodroid.voteme;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

/**
 * Created by Mohamed chiheb on 27/11/2016.
 */

public class MyDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Vote me")
                .setNegativeButton(" ", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                    }
                }).setPositiveButton(" ", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                    }
                }).create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button button2 = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

                // if you do the following it will be left aligned, doesn't look
                // correct
                // button.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_play,
                // 0, 0, 0);

                Drawable drawable = getActivity().getResources().getDrawable(
                        R.drawable.thumbup);

                // set the bounds to place the drawable a bit right
                drawable.setBounds((int) (drawable.getIntrinsicWidth() * 0.5),
                        0, (int) (drawable.getIntrinsicWidth() * 1.5),
                        drawable.getIntrinsicHeight());
                Drawable drawable2 = getActivity().getResources().getDrawable(
                        R.drawable.thumbdown);

                // set the bounds to place the drawable a bit right
                drawable2.setBounds((int) (drawable.getIntrinsicWidth() * 0.5),
                        0, (int) (drawable.getIntrinsicWidth() * 1.5),
                        drawable.getIntrinsicHeight());
                button.setCompoundDrawables(drawable, null, null, null);
                button2.setCompoundDrawables(drawable2, null, null, null);

                // could modify the placement more here if desired
                // button.setCompoundDrawablePadding();
            }
        });
        return dialog;
    }


}