package de.geeksfactory.opacclient.objects;

import java.util.ArrayList;
import java.util.List;

import de.geeksfactory.opacclient.apis.OpacApi;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.os.Bundle;

/**
 * Object representing all details of a media item
 * 
 * @author Raphael Michel
 */
public class DetailledItem {
	private List<Detail> details = new ArrayList<Detail>();
	private List<ContentValues> copies = new ArrayList<ContentValues>();
	private List<ContentValues> baende = new ArrayList<ContentValues>();
	private String cover;
	private String title;
	private Bitmap coverBitmap;
	private boolean reservable;
	private String id;
	private Bundle volumesearch;

	/**
	 * Get unique media identifier
	 * 
	 * @return media ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set unique media identifier
	 * 
	 * @param id
	 *            media ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get media title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set media title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get cover image bitmap
	 */
	public Bitmap getCoverBitmap() {
		return coverBitmap;
	}

	/**
	 * Set cover image bitmap
	 */
	public void setCoverBitmap(Bitmap coverBitmap) {
		this.coverBitmap = coverBitmap;
	}

	/**
	 * Get cover image URL
	 */
	public String getCover() {
		return cover;
	}

	/**
	 * Set cover image URL
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "DetailledItem [details=" + details + ", copies=" + copies
				+ ", cover=" + cover + ", title = " + title + ", reservable = "
				+ reservable + "]";
	}

	/**
	 * Set details (like author, summary, …).
	 * 
	 * @return List of Details
	 * @see Detail
	 */
	public List<Detail> getDetails() {
		return details;
	}

	/**
	 * List of copies of this item available
	 * 
	 * @return List of copies
	 * @see #addCopy(ContentValues)
	 */
	public List<ContentValues> getCopies() {
		return copies;
	}

	/**
	 * List of child items available
	 * 
	 * @return List of child items available
	 * @see #addBand(ContentValues)
	 */
	public List<ContentValues> getBaende() {
		return baende;
	}

	/**
	 * Add a detail
	 * 
	 * @see Detail
	 */
	public void addDetail(Detail detail) {
		details.add(detail);
	}

	/**
	 * Add a copy. <code>copy</code> may contain:
	 * <ul>
	 * <li>"barcode" – copy's barcode</li>
	 * <li>"zst" – branch</li>
	 * <li>"ort" – location</li>
	 * <li>"abt" – department</li>
	 * <li>"status" – current status</li>
	 * <li>"rueckgabe" – date of return</li>
	 * <li>"vorbestellt" – number of reservations pending</li>
	 * </ul>
	 * 
	 * @return List of Details
	 * @see Detail
	 */
	public void addCopy(ContentValues copy) {
		copies.add(copy);
	}

	/**
	 * Add a child item. <code>child</code> must contain:
	 * <ul>
	 * <li>"id" – {@link #getId()}-like identifier of child item</li>
	 * <li>"titel" – the title
	 * </ul>
	 * 
	 * @see Detail
	 */
	public void addBand(ContentValues child) {
		baende.add(child);
	}

	/**
	 * Can return a
	 * {@link de.geeksfactory.opacclient.apis.OpacApi#search(Bundle)} query
	 * <code>Bundle</code> for a volume search based on this item.
	 * 
	 * @return Search query or <code>null</code> if not applicable
	 * @see Detail
	 */
	public Bundle getVolumesearch() {
		return volumesearch;
	}

	/**
	 * Sets a search query which is passed back to your
	 * {@link de.geeksfactory.opacclient.apis.OpacApi#search(Bundle)}
	 * implementation for a volume search based on this item-
	 * 
	 * @param volumesearch
	 *            Search query
	 */
	public void setVolumesearch(Bundle volumesearch) {
		this.volumesearch = volumesearch;
	}

	/**
	 * Returns whether it is possible to order this item through the app
	 * 
	 * @return <code>true</code> if possible, <code>false</code> otherwise.
	 */
	public boolean isReservable() {
		return reservable;
	}

	/**
	 * Specifies whether it is possible to order this item through the app
	 */
	public void setReservable(boolean reservable) {
		this.reservable = reservable;
	}
}
