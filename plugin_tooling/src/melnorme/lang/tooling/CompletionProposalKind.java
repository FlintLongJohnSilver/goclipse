/*******************************************************************************
 * Copyright (c) 2015, 2015 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package melnorme.lang.tooling;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertUnreachable;

@LANG_SPECIFIC
public enum CompletionProposalKind {
	
	KEYWORD,
	ERROR,
	
	MODULEDEC,
	
	VARIABLE,
	
	FUNCTION,
	CONSTRUCTOR,
	
	CLASS,
	INTERFACE,
	STRUCT,
	
	ALIAS
	
	;
	
	
	public <RET> RET switchOnKind(ProposalKindVisitor<RET> visitor) {
		switch(this) {
		case KEYWORD: return visitor.visitKeyword();
		case ERROR: return visitor.visitError();
		
		case MODULEDEC: return visitor.visitModule();
		
		case VARIABLE: return visitor.visitVariable();
		
		case FUNCTION: return visitor.visitFunction();
		case CONSTRUCTOR: return visitor.visitConstructor();
		
		case STRUCT: return visitor.visitStruct();
		case CLASS: return visitor.visitClass();
		case INTERFACE: return visitor.visitInterface();
		
		case ALIAS: return visitor.visitAlias();
		
		}
		throw assertUnreachable();
	}
	
	public static interface ProposalKindVisitor<RET> extends AbstractKindVisitor<RET> {
		
		RET visitError();
		
	}
	
}