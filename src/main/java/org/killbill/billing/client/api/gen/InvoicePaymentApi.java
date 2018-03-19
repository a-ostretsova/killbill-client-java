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
import org.killbill.billing.client.model.gen.InvoicePayment;
import org.killbill.billing.client.model.gen.InvoicePaymentTransaction;
import org.killbill.billing.client.model.gen.PaymentTransaction;
import org.killbill.billing.client.model.gen.Tag;
import java.util.UUID;
import java.util.List;
import org.killbill.billing.client.model.CustomFields;
import org.killbill.billing.client.model.Tags;
import org.killbill.billing.util.api.AuditLevel;

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
public class InvoicePaymentApi {

    private final KillBillHttpClient httpClient;

    public InvoicePaymentApi() {
        this(new KillBillHttpClient());
    }

    public InvoicePaymentApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void completeInvoicePaymentTransaction(final PaymentTransaction body, final UUID paymentId, final List<String> controlPluginName, final List<String> pluginProperty,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling completeInvoicePaymentTransaction");
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling completeInvoicePaymentTransaction");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (controlPluginName != null) {
            queryParams.put("controlPluginName", String.valueOf(controlPluginName));
        }
        if (pluginProperty != null) {
            queryParams.put("pluginProperty", String.valueOf(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

    public InvoicePayment createChargeback(final InvoicePaymentTransaction body, final UUID paymentId,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createChargeback");
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling createChargeback");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/chargebacks"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, InvoicePayment.class, requestOptions);
    }

    public InvoicePayment createChargebackReversal(final InvoicePaymentTransaction body, final UUID paymentId,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createChargebackReversal");
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling createChargebackReversal");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/chargebackReversals"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, InvoicePayment.class, requestOptions);
    }

    public CustomFields createCustomFields(final UUID paymentId, final CustomFields body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling createCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createCustomFields");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/customFields"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, CustomFields.class, requestOptions);
    }

    public InvoicePayment createRefundWithAdjustments(final InvoicePaymentTransaction body, final UUID paymentId, final UUID paymentMethodId, final List<String> pluginProperty,  final RequestOptions inputOptions) throws KillBillClientException {
        return createRefundWithAdjustments(body, paymentId, Boolean.valueOf(false), paymentMethodId, pluginProperty, inputOptions);
    }

    public InvoicePayment createRefundWithAdjustments(final InvoicePaymentTransaction body, final UUID paymentId, final Boolean externalPayment, final UUID paymentMethodId, final List<String> pluginProperty,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createRefundWithAdjustments");
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling createRefundWithAdjustments");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/refunds"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (externalPayment != null) {
            queryParams.put("externalPayment", String.valueOf(externalPayment));
        }
        if (paymentMethodId != null) {
            queryParams.put("paymentMethodId", String.valueOf(paymentMethodId));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", pluginProperty);
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, InvoicePayment.class, requestOptions);
    }

    public Tags createTags(final UUID paymentId, final String tagList,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling createTags");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/tags"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (tagList != null) {
            queryParams.put("tagList", String.valueOf(tagList));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, null, Tags.class, requestOptions);
    }


    public void deleteCustomFields(final UUID paymentId, final String customFieldList,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling deleteCustomFields");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/customFields"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (customFieldList != null) {
            queryParams.put("customFieldList", String.valueOf(customFieldList));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }


    public void deleteTags(final UUID paymentId, final String tagList,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling deleteTags");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/tags"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (tagList != null) {
            queryParams.put("tagList", String.valueOf(tagList));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public CustomFields getCustomFields(final UUID paymentId,  final RequestOptions inputOptions) throws KillBillClientException {
        return getCustomFields(paymentId, AuditLevel.NONE, inputOptions);
    }

    public CustomFields getCustomFields(final UUID paymentId, final AuditLevel audit,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling getCustomFields");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/customFields"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, CustomFields.class, requestOptions);
    }

    public InvoicePayment getInvoicePayment(final UUID paymentId, final List<String> pluginProperty,  final RequestOptions inputOptions) throws KillBillClientException {
        return getInvoicePayment(paymentId, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public InvoicePayment getInvoicePayment(final UUID paymentId, final Boolean withPluginInfo, final Boolean withAttempts, final List<String> pluginProperty, final AuditLevel audit,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling getInvoicePayment");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (withPluginInfo != null) {
            queryParams.put("withPluginInfo", String.valueOf(withPluginInfo));
        }
        if (withAttempts != null) {
            queryParams.put("withAttempts", String.valueOf(withAttempts));
        }
        if (pluginProperty != null) {
            queryParams.put("pluginProperty", String.valueOf(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, InvoicePayment.class, requestOptions);
    }

    public Tags getTags(final UUID paymentId, final List<String> pluginProperty,  final RequestOptions inputOptions) throws KillBillClientException {
        return getTags(paymentId, pluginProperty, AuditLevel.NONE, Boolean.valueOf(false), inputOptions);
    }

    public Tags getTags(final UUID paymentId, final List<String> pluginProperty, final AuditLevel audit, final Boolean includedDeleted,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling getTags");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/tags"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (pluginProperty != null) {
            queryParams.put("pluginProperty", String.valueOf(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }
        if (includedDeleted != null) {
            queryParams.put("includedDeleted", String.valueOf(includedDeleted));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Tags.class, requestOptions);
    }

    public void modifyCustomFields(final UUID paymentId, final CustomFields body,  final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentId, "Missing the required parameter 'paymentId' when calling modifyCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling modifyCustomFields");

        final String uri = "/1.0/kb/invoicePayments/{paymentId}/customFields"
          .replaceAll("\\{" + "paymentId" + "\\}", paymentId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

}
