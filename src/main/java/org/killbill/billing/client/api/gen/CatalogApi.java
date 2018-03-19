/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package org.killbill.billing.client.api.gen;


import org.killbill.billing.client.model.gen.Phase;
import org.killbill.billing.client.model.gen.Plan;
import org.killbill.billing.client.model.gen.PlanDetail;
import org.killbill.billing.client.model.gen.PriceList;
import org.killbill.billing.client.model.gen.Product;
import org.killbill.billing.client.model.gen.SimplePlan;
import org.killbill.billing.client.model.gen.StaticCatalog;
import java.util.UUID;
import org.killbill.billing.client.model.PlanDetails;
import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.base.Preconditions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.LinkedListMultimap;

import org.killbill.billing.client.KillBillClientException;
import org.killbill.billing.client.KillBillHttpClient;
import org.killbill.billing.client.RequestOptions;
import org.killbill.billing.client.RequestOptions.RequestOptionsBuilder;


/**
 *           DO NOT EDIT !!!
 *
 * This code has been generated by the Kill Bill swagger generator.
 *  @See https://github.com/killbill/killbill-swagger-coden
 */
public class CatalogApi {

    private final KillBillHttpClient httpClient;

    public CatalogApi() {
        this(new KillBillHttpClient());
    }

    public CatalogApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void addSimplePlan(final SimplePlan body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling addSimplePlan");

        final String uri = "/1.0/kb/catalog/simplePlan";


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPost(uri, body, requestOptions);
    }


    public void deleteCatalog( final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog";


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public PlanDetails getAvailableAddons(final String baseProductName, final String priceListName,  final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog/availableAddons";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (baseProductName != null) {
            queryParams.put("baseProductName", String.valueOf(baseProductName));
        }
        if (priceListName != null) {
            queryParams.put("priceListName", String.valueOf(priceListName));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PlanDetails.class, requestOptions);
    }

    public PlanDetails getAvailableBasePlans( final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog/availableBasePlans";


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PlanDetails.class, requestOptions);
    }

    public StaticCatalog getCatalogJson(final String requestedDate,  final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, StaticCatalog.class, requestOptions);
    }

    public Phase getPhaseForSubscriptionAndDate(final UUID subscriptionId, final String requestedDate,  final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog/phase";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (subscriptionId != null) {
            queryParams.put("subscriptionId", String.valueOf(subscriptionId));
        }
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Phase.class, requestOptions);
    }

    public Plan getPlanForSubscriptionAndDate(final UUID subscriptionId, final String requestedDate,  final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog/plan";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (subscriptionId != null) {
            queryParams.put("subscriptionId", String.valueOf(subscriptionId));
        }
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Plan.class, requestOptions);
    }

    public PriceList getPriceListForSubscriptionAndDate(final UUID subscriptionId, final String requestedDate,  final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog/priceList";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (subscriptionId != null) {
            queryParams.put("subscriptionId", String.valueOf(subscriptionId));
        }
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PriceList.class, requestOptions);
    }

    public Product getProductForSubscriptionAndDate(final UUID subscriptionId, final String requestedDate,  final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/catalog/product";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (subscriptionId != null) {
            queryParams.put("subscriptionId", String.valueOf(subscriptionId));
        }
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Product.class, requestOptions);
    }

    public void uploadCatalogXml(final String body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling uploadCatalogXml");

        final String uri = "/1.0/kb/catalog";


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "text/xml");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPost(uri, body, requestOptions);
    }

}
