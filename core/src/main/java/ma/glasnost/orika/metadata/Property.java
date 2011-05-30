/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ma.glasnost.orika.metadata;

import java.util.Collection;

// XXX must be immutable
public class Property {
	private static final Property[] EMPTY_PATH = new Property[0];
	private String name;
	private String getter;
	private String setter;
	private Class<?> type;
	private Class<?> parameterizedType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getSetter() {
		return setter;
	}

	public void setSetter(String setter) {
		this.setter = setter;
	}

	public Class<?> getParameterizedType() {
		return parameterizedType;
	}

	public void setParameterizedType(Class<?> parameterizedType) {
		this.parameterizedType = parameterizedType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Property property = (Property) o;

		if (getter != null ? !getter.equals(property.getter) : property.getter != null)
			return false;
		if (!name.equals(property.name))
			return false;
		if (setter != null ? !setter.equals(property.setter) : property.setter != null)
			return false;
		return !(type != null && !type.equals(property.type));

	}

	public boolean isPrimitive() {
		return type.isPrimitive();
	}

	public boolean isArray() {
		return type.isArray();
	}

	public boolean isAssignableFrom(Property p) {
		return type.isAssignableFrom(p.type);
	}

	public boolean isCollection() {
		return Collection.class.isAssignableFrom(type);
	}

	public boolean hasPath() {
		return false;
	}

	public Property[] getPath() {
		return EMPTY_PATH;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + (getter != null ? getter.hashCode() : 0);
		result = 31 * result + (setter != null ? setter.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}
}