
package com.emuniapp.emuni.Activity;

/**
 * Created by Mitch on 2016-05-13.
 */

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import com.emuniapp.emuni.R;
        import com.emuniapp.emuni.classes.Category;
        import com.emuniapp.emuni.classes.Product;

        import java.util.ArrayList;

/**
 * Created by Mitch on 2016-05-06.
 */
public class ThreeColumn_ProductAdapter extends ArrayAdapter<Product> {

    private LayoutInflater mInflater;
    private ArrayList<Product> products;
    private int mViewResourceId;

    public ThreeColumn_ProductAdapter(Context context, int textViewResourceId, ArrayList<Product> products) {
        super(context, textViewResourceId, products);
        this.products = products;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Product product = products.get(position);
        if (product != null) {
            TextView firstName = (TextView) convertView.findViewById(R.id.tvId);
            TextView lastName = (TextView) convertView.findViewById(R.id.tvName);
            TextView favFood = (TextView) convertView.findViewById(R.id.desc);
            TextView productnumber = (TextView) convertView.findViewById(R.id.productnumber);

            if (firstName != null) {
                firstName.setText(product.getCat_id());
            }
            if (lastName != null) {
                lastName.setText((product.getProduct_name()));
            }
            if (favFood != null) {
                favFood.setText((product.getProduct_price()));
            }
            if (productnumber != null) {
                productnumber.setText((product.getProduct_number()));
            }
        }

        return convertView;
    }
}
