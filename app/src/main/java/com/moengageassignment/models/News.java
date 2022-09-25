package com.moengageassignment.models;

public class News {
    public String headLines , newsDetails;

    public String getHeadLines() {
        return headLines;
    }

    public void setHeadLines(String headLines) {
        this.headLines = headLines;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }


//    public String country;
//    public String viewability;
//    public boolean embeddable;
//    public boolean publicDomain;
//    public String textToSpeechPermission;
//    public Epub epub;
//    public Pdf pdf;
//    public String webReaderLink;
//    public String accessViewStatus;
//    public boolean quoteSharingAllowed;
//
//
//    public class Epub {
//        public boolean isAvailable;
//        public String acsTokenLink;
//    }
//
//    public class ImageLinks {
//        public String smallThumbnail;
//        public String thumbnail;
//    }
//
//    public class IndustryIdentifier {
//        public String type;
//        public String identifier;
//    }
//
//    public class Item {
//        public String kind;
//        public String id;
//        public String etag;
//        public String selfLink;
//        public VolumeInfo volumeInfo;
//        public SaleInfo saleInfo;
//        public News accessInfo;
//        public SearchInfo searchInfo;
//    }
//
//    public class ListPrice {
//        public double amount;
//        public String currencyCode;
//        public int amountInMicros;
//    }
//
//    public class Offer {
//        public int finskyOfferType;
//        public ListPrice listPrice;
//        public RetailPrice retailPrice;
//    }
//
//    public class PanelizationSummary {
//        public boolean containsEpubBubbles;
//        public boolean containsImageBubbles;
//    }
//
//    public class Pdf {
//        public boolean isAvailable;
//    }
//
//    public class ReadingModes {
//        public boolean text;
//        public boolean image;
//    }
//
//    public class RetailPrice {
//        public double amount;
//        public String currencyCode;
//        public int amountInMicros;
//    }
//
//    public class Root {
//        public String kind;
//        public int totalItems;
//        public ArrayList<Item> items;
//    }
//
//    public class SaleInfo {
//        public String country;
//        public String saleability;
//        public boolean isEbook;
//        public ListPrice listPrice;
//        public RetailPrice retailPrice;
//        public String buyLink;
//        public ArrayList<Offer> offers;
//    }
//
//    public class SearchInfo {
//        public String textSnippet;
//    }
//
//    public class VolumeInfo {
//        public String title;
//        public String subtitle;
//        public ArrayList<String> authors;
//        public String publisher;
//        public String publishedDate;
//        public String description;
//        public ArrayList<IndustryIdentifier> industryIdentifiers;
//        public ReadingModes readingModes;
//        public int pageCount;
//        public String printType;
//        public ArrayList<String> categories;
//        public int averageRating;
//        public int ratingsCount;
//        public String maturityRating;
//        public boolean allowAnonLogging;
//        public String contentVersion;
//        public PanelizationSummary panelizationSummary;
//        public ImageLinks imageLinks;
//        public String language;
//        public String previewLink;
//        public String infoLink;
//        public String canonicalVolumeLink;
//    }
}