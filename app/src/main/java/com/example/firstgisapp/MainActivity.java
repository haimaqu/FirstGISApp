package com.example.firstgisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class MainActivity extends AppCompatActivity {
    //定义一个MapView对象
    public MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将MapVIew对象与控件进行绑定
        this.mMapView = (MapView)this.findViewById(R.id.mapView);
        // 创建一个地图对象
        ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 34.056295, -117.195800, 16);
        // 设置地图展示在MapView控件中
        mMapView.setMap(map);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mMapView.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mMapView.resume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.dispose();
    }
}
//        思路：MapView用于显示地图（ArcGISMap），而地图（ArcGISMap）需要设置底图（Basemap)，底图（Basemap)需要图层（ArcGISTiledLayer）

//        //在Layout中获取到MapView控件，记得在外层创建mMapView对象
//        mMapView = (MapView) findViewById(R.id.mapView);
//        //创建一个地图对象
//        ArcGISMap map = new ArcGISMap();
//         //创建并添加地图服务
//        String strMapUrl="http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineCommunity/MapServer";
//        ArcGISTiledLayer arcGISTiledLayer = new ArcGISTiledLayer(strMapUrl);
//        //创建底图、并设置底图图层
//        Basemap basemap = new Basemap();
//        basemap.getBaseLayers().add(arcGISTiledLayer);
//        //设置地图底图
//        map.setBasemap(basemap);
//        //设置map地图对象在MapView控件中显示
//        mMapView.setMap(map);


