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

package com.pacoworks.dereference.features.home

import com.pacoworks.rxcomprehensions.RxComprehensions.doFM
import rx.Subscription

fun startHomeInteractor(view: HomeView, state: HomeState) {
    subscribeHomeInteractor(view, state)
    bindHomeInteractor(view, state)
}

private fun bindHomeInteractor(view: HomeView, state: HomeState) {
    view.createBinder<Int>().call(state.counter, { view.setTitle(it.toString()) })
}

private fun subscribeHomeInteractor(view: HomeView, state: HomeState) =
        startClicks(view, state)

private fun startClicks(view: HomeView, state: HomeState): Subscription =
        doFM(
                { view.clicks() },
                { state.counter.first().map { it + 1 } }
        ).subscribe(state.counter)