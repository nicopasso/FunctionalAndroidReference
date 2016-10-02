/*
 * Copyright (c) pakoito 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.dereference.features.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacoworks.dereference.features.global.BaseController;

import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;

import rx.Observable;

public class ListScreen extends BaseController implements ListExampleView {

    private static final int SPAN_COUNT = 3;

    @NonNull
    @Override
    protected View createView(Context context, LayoutInflater inflater, ViewGroup container) {
        final RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, SPAN_COUNT));
        recyclerView.setAdapter(new ListExampleAdapter());
        return recyclerView;
    }

    @Override
    protected void attachBinders() {

    }

    @NonNull
    @Override
    public Observable<Pair<Integer, String>> listClicks() {
        return getCastedAdapter().getClicks();
    }

    @NotNull
    @Override
    public Observable<Pair<Integer, String>> listLongClicks() {
        return getCastedAdapter().getLongClicks();
    }

    private ListExampleAdapter getCastedAdapter() {
        return (ListExampleAdapter) ((RecyclerView) getView()).getAdapter();
    }


}