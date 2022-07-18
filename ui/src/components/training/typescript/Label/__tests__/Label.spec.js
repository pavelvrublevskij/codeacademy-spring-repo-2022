import { render, screen } from '@testing-library/react';
import Label from '../Label';

describe('Label', () => {
    it('should render same text with the provided text', () => {
        const textMessage = 'Text';

        render(<Label text={textMessage} />);

        expect(screen.getByText(textMessage)).toBeInTheDocument();
    });
});
