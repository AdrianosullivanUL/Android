package ie.ul.adrianosullivan.pointofsale;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private TextView mName_text;
    private TextView mQuantity_text;
    private TextView mDate_text;
    private Item mCurrentItem;
    private Item mClearedItem;
    private ArrayList<Item> mItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = new ArrayList<>();
        mName_text = findViewById(R.id.name_text);
        mQuantity_text = findViewById(R.id.quantity_text);
        mDate_text = findViewById(R.id.date_text);
        mItems.add(new Item("Example 1", 1, new GregorianCalendar()));
        mItems.add(new Item("Example 2", 11, new GregorianCalendar()));
        mItems.add(new Item("Example 3", 12, new GregorianCalendar()));
        mCurrentItem= mItems.get(0);

        registerForContextMenu(mName_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem(false);
            }
        });
    }

    private void insertItem(final boolean isEdit) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.AddanItem);




        View view = getLayoutInflater().inflate(R.layout.dialog_add, null, false);
        builder.setView(view);
        final EditText nameEditText = view.findViewById(R.id.edit_name);
        final EditText quantityEditText = view.findViewById(R.id.edit_quantity);
        final CalendarView deliveryDateView = view.findViewById(R.id.date_text);
        final GregorianCalendar calendar = new GregorianCalendar();

        if (isEdit)
        {
nameEditText.setText(mCurrentItem.getName().toString());
quantityEditText.setText("" + mCurrentItem.getQuantity());
//deliveryDateView.setDate(mCurrentItem.getDeliveryDateTime());
        }

        // deliveryDateView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        //      @Override
        //      public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        //          calendar.set(year, month, dayOfMonth);
        //     }
        //  });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = nameEditText.getText().toString();
                int quantity = Integer.parseInt(quantityEditText.getText().toString());
                if (isEdit)
                {
                 mCurrentItem.setName(name);
                 mCurrentItem.setQuantity(quantity);
                 //mCurrentItem.setDeliveryDate(calendar);
                } else {
                    mCurrentItem = new Item(name, quantity, calendar);
                    mItems.add(mCurrentItem);
                }
                showCurrentItem();
            }
        });
        builder.create().show();


    }

    private void showCurrentItem() {
        mName_text.setText(mCurrentItem.getName());
        mQuantity_text.setText(getString(R.string.quantity_format,
                mCurrentItem.getQuantity()));
        mDate_text.setText(getString(R.string.date_format, mCurrentItem.getDeliveryDateString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contextual_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch  (item.getItemId()) {
            case R.id.action_edit:
                insertItem(true);
                return true;
            case R.id.action_remove:
                mItems.remove((mCurrentItem));
                mCurrentItem = new Item();
                showCurrentItem();;
                return true;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_reset:
                mClearedItem = mCurrentItem;
                mCurrentItem = new Item();
                showCurrentItem();
                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator_layout), "Item Cleared",
                        Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCurrentItem = mClearedItem;
                        showCurrentItem();
                        Snackbar.make(findViewById(R.id.coordinator_layout), "Item Restored", Snackbar.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
                return true;
            case R.id.action_search:
                ShowSearchDialog();
                return true;
            case R.id.action_settings:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                return true;
            case R.id.action_clear_all:
                clearAllItems();
                return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void clearAllItems() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove");
        builder.setMessage("Are you sure you wish to remove all items?");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mItems.clear();
                mCurrentItem = new Item();
                showCurrentItem();
            }
        });

        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();

    }

    private void ShowSearchDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.choose_an_item);
        builder.setItems(getNames(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mCurrentItem = mItems.get(which);
                showCurrentItem();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();

    }

    private String[] getNames() {
        String[] names = new String[mItems.size()];
        for (int i = 0; i < mItems.size(); i++)
            names[i] = mItems.get(i).getName();
        return names;
    }
}
