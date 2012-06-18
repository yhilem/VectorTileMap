/*
 * Copyright 2010, 2011, 2012 mapsforge.org
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mapsforge.android.maps.rendertheme;

import org.mapsforge.core.Tag;

class NegativeRule extends Rule {
	final AttributeMatcher mAttributeMatcher;

	NegativeRule(ElementMatcher elementMatcher, ClosedMatcher closedMatcher, byte zoomMin, byte zoomMax,
			AttributeMatcher attributeMatcher) {
		super(elementMatcher, closedMatcher, zoomMin, zoomMax);

		mAttributeMatcher = attributeMatcher;
	}

	@Override
	boolean matchesNode(Tag[] tags, byte zoomLevel) {
		return mZoomMin <= zoomLevel && mZoomMax >= zoomLevel
				&& (mElementMatcher == null || mElementMatcher.matches(Element.NODE))
				&& mAttributeMatcher.matches(tags);
	}

	@Override
	boolean matchesWay(Tag[] tags, byte zoomLevel, Closed closed) {
		return mZoomMin <= zoomLevel && mZoomMax >= zoomLevel
				&& (mElementMatcher == null || mElementMatcher.matches(Element.WAY))
				&& (mClosedMatcher == null || mClosedMatcher.matches(closed)) && mAttributeMatcher.matches(tags);
	}
}
