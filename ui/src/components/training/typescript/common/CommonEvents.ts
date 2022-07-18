import React from 'react';

export interface ClickEvent {
    onClick?(event: React.MouseEvent<HTMLElement>): void;
}
