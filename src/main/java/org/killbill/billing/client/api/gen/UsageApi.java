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


import org.killbill.billing.client.model.gen.RolledUpUsage;
import org.killbill.billing.client.model.gen.SubscriptionUsageRecord;
import java.util.UUID;

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
public class UsageApi {

    private final KillBillHttpClient httpClient;

    public UsageApi() {
        this(new KillBillHttpClient());
    }

    public UsageApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public RolledUpUsage getAllUsage(final UUID subscriptionId, final String startDate, final String endDate,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling getAllUsage");

        final String uri = "/1.0/kb/usages/{subscriptionId}"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (startDate != null) {
            queryParams.put("startDate", String.valueOf(startDate));
        }
        if (endDate != null) {
            queryParams.put("endDate", String.valueOf(endDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, RolledUpUsage.class, requestOptions);
    }

    public RolledUpUsage getUsage(final UUID subscriptionId, final String unitType, final String startDate, final String endDate,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling getUsage");
        Preconditions.checkNotNull(unitType, "Missing the required parameter 'unitType' when calling getUsage");

        final String uri = "/1.0/kb/usages/{subscriptionId}/{unitType}"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString())
          .replaceAll("\\{" + "unitType" + "\\}", unitType.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (startDate != null) {
            queryParams.put("startDate", String.valueOf(startDate));
        }
        if (endDate != null) {
            queryParams.put("endDate", String.valueOf(endDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, RolledUpUsage.class, requestOptions);
    }

    public void recordUsage(final SubscriptionUsageRecord body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling recordUsage");

        final String uri = "/1.0/kb/usages";


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPost(uri, body, requestOptions);
    }

}
