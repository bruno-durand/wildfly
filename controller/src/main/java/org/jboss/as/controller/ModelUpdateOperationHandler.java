/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.controller;

import org.jboss.dmr.ModelNode;

/**
 * A model update operation handler.  An update operation can directly operate on and modify a sub-model.  Update
 * operations may be blocked for some period of time (for example, if an operation plan with a rollback
 * component is executing).
 *
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public interface ModelUpdateOperationHandler extends ModelQueryOperationHandler {

    /**
     * Execute the model update, passing the result to {@code resultHandler}. This method <b>must</b> invoke one of the
     * completion methods on {@code resultHandler} regardless of the outcome of the operation.
     *
     * @param context the context for this operation
     * @param operation the operation being executed
     * @param resultHandler the result handler to invoke when the operation is complete
     *
     * @return a handle which may be used to asynchronously cancel this operation
     */
    Cancellable execute(OperationContext context, ModelNode operation, ResultHandler resultHandler);
}
