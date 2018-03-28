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


import org.killbill.billing.client.model.gen.CustomField;
import org.killbill.billing.client.model.gen.Payment;
import org.killbill.billing.client.model.gen.PaymentTransaction;
import org.killbill.billing.client.model.gen.Tag;
import java.util.UUID;
import org.killbill.billing.client.model.CustomFields;
import java.util.List;
import org.killbill.billing.client.model.Tags;
import org.killbill.billing.util.api.AuditLevel;
import java.util.Map;

import com.google.common.collect.Multimap;
import com.google.common.base.Preconditions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.LinkedListMultimap;

import org.killbill.billing.client.Converter;
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
public class PaymentTransactionApi {

    private final KillBillHttpClient httpClient;

    public PaymentTransactionApi() {
        this(new KillBillHttpClient());
    }

    public PaymentTransactionApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CustomFields createCustomFields(final UUID transactionId, final CustomFields body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling createCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createCustomFields");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/customFields"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, CustomFields.class, requestOptions);
    }

    public Tags createTags(final UUID transactionId, final List<String> tagDef,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling createTags");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/tags"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (tagDef != null) {
            queryParams.putAll("tagDef", tagDef);
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, null, Tags.class, requestOptions);
    }


    public void deleteCustomFields(final UUID transactionId, final List<UUID> customField,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling deleteCustomFields");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/customFields"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (customField != null) {
            queryParams.putAll("customField", Converter.convertUUIDListToStringList(customField));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }


    public void deleteTags(final UUID transactionId, final List<UUID> tagDef,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling deleteTags");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/tags"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (tagDef != null) {
            queryParams.putAll("tagDef", Converter.convertUUIDListToStringList(tagDef));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public CustomFields getCustomFields(final UUID transactionId,  final RequestOptions inputOptions) throws KillBillClientException {
        return getCustomFields(transactionId, AuditLevel.NONE, inputOptions);
    }

    public CustomFields getCustomFields(final UUID transactionId, final AuditLevel audit,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling getCustomFields");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/customFields"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, CustomFields.class, requestOptions);
    }

    public Payment getPaymentByTransactionId(final UUID transactionId, final Map<String, String> pluginProperty,  final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentByTransactionId(transactionId, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public Payment getPaymentByTransactionId(final UUID transactionId, final Boolean withPluginInfo, final Boolean withAttempts, final Map<String, String> pluginProperty, final AuditLevel audit,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling getPaymentByTransactionId");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (withPluginInfo != null) {
            queryParams.put("withPluginInfo", String.valueOf(withPluginInfo));
        }
        if (withAttempts != null) {
            queryParams.put("withAttempts", String.valueOf(withAttempts));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Payment.class, requestOptions);
    }

    public Tags getTags(final UUID transactionId,  final RequestOptions inputOptions) throws KillBillClientException {
        return getTags(transactionId, Boolean.valueOf(false), AuditLevel.NONE, inputOptions);
    }

    public Tags getTags(final UUID transactionId, final Boolean includedDeleted, final AuditLevel audit,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling getTags");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/tags"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (includedDeleted != null) {
            queryParams.put("includedDeleted", String.valueOf(includedDeleted));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Tags.class, requestOptions);
    }

    public void modifyCustomFields(final UUID transactionId, final CustomFields body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling modifyCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling modifyCustomFields");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}/customFields"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

    public Payment notifyStateChanged(final PaymentTransaction body, final UUID transactionId, final List<String> controlPluginName,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling notifyStateChanged");
        Preconditions.checkNotNull(transactionId, "Missing the required parameter 'transactionId' when calling notifyStateChanged");

        final String uri = "/1.0/kb/paymentTransactions/{transactionId}"
          .replaceAll("\\{" + "transactionId" + "\\}", transactionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (controlPluginName != null) {
            queryParams.putAll("controlPluginName", controlPluginName);
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, Payment.class, requestOptions);
    }

}
