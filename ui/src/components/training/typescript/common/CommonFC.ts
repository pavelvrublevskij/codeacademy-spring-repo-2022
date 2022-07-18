import { ClickEvent } from './CommonEvents';
import React from 'react';

export interface CommonProps extends ClickEvent {
    id?: string;
    testId?: string;
}

export interface CommonFC<P extends ClickEvent> extends React.FC<P> {}
